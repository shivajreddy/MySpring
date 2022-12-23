import axios from 'axios';

const BASE_URL = 'http://localhost:8080/employee';

class EmployeeService {
  getEmployees () {
    return axios.get(BASE_URL + '/all');
  }
  
  deleteAllEmployees () {
    return axios({
      method: 'delete',
      url: BASE_URL + '/all',
    });
  }
  
  updateEmployee (id, firstName, lastName) {
    return axios({
      method: 'patch',
      url: BASE_URL + '/' + id,
      headers: {},
      data: { firstName: firstName, lastName: lastName },
    });
  }
  
  createNewEmployee (firstName, lastName) {
    return axios({
      method: 'post',
      url: BASE_URL + '/new',
      headers: {},
      data: { firstName: firstName, lastName: lastName },
    });
  }
  
}

export default new EmployeeService();