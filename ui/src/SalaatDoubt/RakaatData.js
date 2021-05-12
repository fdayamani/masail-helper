import axios from 'axios'
import config from '../config'

const BASE_URL = config.BASE_URL

class RakaatData {

    sendSalaatData(rakaat) {
        axios.post(`${BASE_URL}/rakaat/`, rakaat, { headers: { "Content-Type": "text/plain" } })
    }

    sendOptionData(option) {
        axios.post(`${BASE_URL}/option/`, option, { headers: { "Content-Type": "text/plain" } })
             .catch(error => console.log(error.response.data.message))
    }

    actionOptions() {
        return axios.get(`${BASE_URL}/actionOptions`);
    }

    sendActionData(action) {
        axios.post(`${BASE_URL}/action/`, action, { headers: { "Content-Type": "text/plain" } })
    }

    remedy() {
        return axios.get(`${BASE_URL}/remedy`);
    }
}

export default new RakaatData()