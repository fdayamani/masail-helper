import {Component} from "react";
import RakaatData from "./RakaatData"
import { Button } from '@material-ui/core';


class Remedy extends Component {

    constructor(props) {
        super(props)
        this.state = {remedy: []}
    }

    getRemedy() {
        RakaatData.remedy()
            .then(
                response => {
                    console.log(response);
                    this.setState({remedy: response.data})
                }
            )
    }

    render() {
       return <div>
           <Button onClick={() => this.getRemedy()}>
                Get Remedial Action
           </Button>
           <div style={{"white-space": "pre-wrap"}}>{this.state.remedy.map(element =>
           "Assume this is your " + element.assumption + " rak'ah \n\n" +
           "Perform " + element.number + " units of " + element.actionType.name + " " + element.actionType.mode + "\n\n" +
           "Method: \n" + element.actionType.method
            )}</div>
       </div>
    }
}

export default Remedy