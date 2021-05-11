import {Component} from "react";
import { Button } from '@material-ui/core';
import RakaatData from "./RakaatData"

class Options extends Component {

    constructor(props) {
        super(props)
        this.state = {options: []}
    }

    componentDidUpdate(prevState) {
        if (this.state.options.size === 2) {RakaatData.sendOptionsData(this.state.options)}
    }

    render() {
       return <div>
            <p>Which rakaats were you confused between? (Select 2)</p>
            {[...Array(6).keys()].map(key => key + 1).map(
                option => <Button key={option} onClick={() => this.setState({options: [...this.state.options, option]})}>{option}</Button>
            )}
       </div>
    }
}

export default Options