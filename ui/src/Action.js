import {Component} from "react";
import { Button } from '@material-ui/core';
import RakaatData from "./RakaatData"

class Action extends Component {

    constructor(props) {
        super(props)
        this.state = {possibleActions: []}
        this.sendActionData = RakaatData.sendActionData
    }

    componentDidMount() {
        RakaatData.actionOptions()
            .then(
                response => {
                    this.setState({possibleActions: response.data})
                }
            )
    }

    render() {
       return <div>
            <p>Which action did the doubt occur in?</p>
            {this.state.possibleActions.map(
                action => <Button key={action} onClick={() => this.sendActionData(action)}>{action}</Button>
            )}
       </div>
    }
}

export default Action