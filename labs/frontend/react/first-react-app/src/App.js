// imports
import logo from './logo.svg';
import './App.css';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';
import HomePage from './pages/HomePage/HomePage';

// Component Definition
const App = () => {
  // JSX - Javascript Extension for XML
  return (
    <>
      <Header/>
      <HomePage/>
      <Footer/>
    </>
  );
}

// Exports
export default App;
