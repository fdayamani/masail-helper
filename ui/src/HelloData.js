import axios from 'axios'

const BASE_URL = 'http://localhost:8080'
const HELLO_URL = `${BASE_URL}/helloworld`

class HelloData {

    greeting() {
        return axios.get(`${HELLO_URL}`);
    }
}

export default new HelloData()