import {Component} from "react";
import { Button } from '@material-ui/core';
import RakaatData from "./RakaatData"

class Salaat extends Component {

    constructor(props) {
        super(props)
        this.state = {possibleSalaats: []}
        this.sendSalaatData = RakaatData.sendSalaatData
    }

    componentDidMount() {
        RakaatData.salaatOptions()
            .then(
                response => {
                    this.setState({possibleSalaats: response.data})
                }
            )
    }

    render() {
       return <div>
            <p>Which salaat did the doubt occur in?</p>
            {this.state.possibleSalaats.map(
                salaat => <Button key={salaat} onClick={() => this.sendSalaatData(salaat)}>{salaat}</Button>
            )}
       </div>
    }
}

export default Salaat