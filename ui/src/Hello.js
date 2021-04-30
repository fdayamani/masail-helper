import {Component} from "react";
import HelloData from "./HelloData"

class Hello extends Component {

    constructor(props) {
        super(props)
        this.state = {greeting: ""}
    }

    componentDidMount() {
        HelloData.greeting()
            .then(
                response => {
                    console.log(response);
                    this.setState({greeting: response.data})
                }
            )
    }

    render() {
       return <div>
            {this.state.greeting}
       </div>
    }
}

export default Hello