import {Component} from "react";
import Salaat from "./Salaat"
import Options from "./Options"
import Action from "./Action"
import Remedy from "./Remedy"

class Rakaat extends Component {
    render() {
       return <div>
            <Salaat/>
            <Options/>
            <Action/>
            <Remedy/>
       </div>
    }
}

export default Rakaat