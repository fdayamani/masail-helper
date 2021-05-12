import {Component} from "react";
import { Button } from '@material-ui/core';
import RakaatData from "./RakaatData"

class Salaat extends Component {

    constructor(props) {
        super(props)
        this.sendSalaatData = RakaatData.sendSalaatData
    }

    render() {
       return <div>
            <p>How many rakaat was your salaat?</p>
            {[...Array(3).keys()].map(key => key + 2).map(
                 rakaats => <Button key={rakaats} onClick={() => this.sendSalaatData(rakaats)}>{rakaats}</Button>
            )}
       </div>
    }
}

export default Salaat