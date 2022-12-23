import './App.css';
import AllEmployees from './components/AllEmployees';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Nav from './components/Nav';
import NewEmployee from './components/NewEmployee';

function App () {
  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route exact path="/" element={<AllEmployees/>}/>
        <Route exact path="/new" element={<NewEmployee/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
