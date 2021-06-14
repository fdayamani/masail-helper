import {Component} from "react";
import RakaatData from "./RakaatData"
import { Button } from '@material-ui/core';


class Remedy extends Component {

    constructor(props) {
        super(props)
        this.state = {remedy: {assumption: 0, actions: []}}
    }

    getRemedy() {
        RakaatData.remedy()
            .then(
                response => {
                    console.log(response);
                    this.setState({remedy: {assumption: response.data.assumption, actions: response.data.actions}})
                }
            )
    }

    render() {
       return <div>
           <Button onClick={() => this.getRemedy()}>
                Get Remedial Action
           </Button>
           <div>
           {this.state.remedy.assumption > 0 ? "Assume this is your " + this.state.remedy.assumption + " rak'ah \n\n" : ""}
           </div>
           <div style={{"whiteSpace": "pre-wrap"}}>{this.state.remedy.actions.map(element =>
                        this.state.remedy.assumption > 0 ?
                         "Perform " + element.number + " units of " + element.actionType.name + " " + element.actionType.mode + "\n\n" +
                         "Method: \n" + element.actionType.method
                         :
                         element.actionType.name
                       )}
           </div>
       </div>
    }
}

export default Remedy