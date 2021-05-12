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
        return axios.get(`${BASE_URL}/rakaat`);
    }
}

export default new RakaatData()