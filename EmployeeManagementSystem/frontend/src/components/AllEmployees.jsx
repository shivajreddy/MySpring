import React, { useEffect } from 'react';
import EmployeeService from '../services/EmployeeService';

function AllEmployees () {
  
  const [allEmployees, setAllEmployees] = React.useState([]);
  
  useEffect(() => {
    EmployeeService.getEmployees().then((res) => {
      setAllEmployees(res.data);
    });
  }, []);
  
  console.log('all employees = ', allEmployees);
  
  return (
    <div>
      <h2>All employees</h2>
      <div>
        <h2 className="text-center">Employees list</h2>
        <div className="row">
          <table className="table table-striped table-bordered">
        
            <thead>
            <tr>
              <th>Employee First Name</th>
              <th>Employee Last Name</th>
              <th>Employee Email</th>
              <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {
              allEmployees.map(
                employee =>
                  <tr key={employee.id}>
                    <td>{employee.firstName}</td>
                    <td>{employee.lastName}</td>
                    <td>{employee.email}</td>
                  </tr>,
              )
            }
            </tbody>
          </table>
        </div>
  
      </div>
    </div>
  );
  
}

export default AllEmployees;