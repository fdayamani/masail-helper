import axios from 'axios'
import config from '../config'

const BASE_URL = config.BASE_URL

class RakaatData {

    salaatOptions() {
        return axios.get(`${BASE_URL}/salaatOptions`);
    }

    sendSalaatData(salaat) {
        axios.post(`${BASE_URL}/salaat/`, salaat, { headers: { "Content-Type": "text/plain" } })
    }

    sendOptionsData([option1, option2]) {
        axios.post(`${BASE_URL}/salaat/`, {options: [option1, option2]}, { headers: { "Content-Type": "application/json" } })
    }

    actionOptions() {
        return axios.get(`${BASE_URL}/actionOptions`);
    }

    sendActionData(action) {
        axios.post(`${BASE_URL}/action/`, action, { headers: { "Content-Type": "text/plain" } })
    }

    remedy() {
        return axios.get(`${BASE_URL}/rakaat`);
    }
}

export default new RakaatData()