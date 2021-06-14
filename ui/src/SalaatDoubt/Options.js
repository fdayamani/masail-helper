import {Component} from "react";
import { Button } from '@material-ui/core';
import RakaatData from "./RakaatData"

class Options extends Component {

    constructor(props) {
        super(props)
        this.sendOption = RakaatData.sendOptionData
        this.state = {errors: []}
    }

    render() {
       return <div>
            <p>Which rakaats were you confused between? (Select up to 3)</p>
            {[...Array(6).keys()].map(key => key + 1).map(
                option => <Button key={option} onClick={() => this.sendOption(option)}>{option}</Button>
            )}
           {this.state.errors.length > 1 ? this.state.errors.map(error => <p>error</p>) : <div></div>}
       </div>
    }
}

export default Options