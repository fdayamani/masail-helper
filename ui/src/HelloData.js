import axios from 'axios'
import config from './config'

const BASE_URL = config.BASE_URL
const HELLO_URL = `${BASE_URL}/helloworld`

class HelloData {

    greeting() {
        return axios.get(`${HELLO_URL}`);
    }
}

export default new HelloData()