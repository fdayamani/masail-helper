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
           <p>{this.state.remedy.map(element =>
           "Assumption: " + element.assumption + "\n" +
           "Action: " + element.actionType + "\n" +
           "Number: " + element.number
            )}</p>
       </div>
    }
}

export default Remedy