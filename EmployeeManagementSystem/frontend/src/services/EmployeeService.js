import axios from 'axios'

const BASE_URL = 'http://localhost:8080/employee'

class EmployeeService {
  getEmployees () {
    return axios.get(BASE_URL + '/all')
  }
}

export default new EmployeeService()