import React from 'react';
import logo from './logo.svg';
import StockPrice from './components/StockPrice';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} width={"150"} className="App-logo" alt="logo" />
        <StockPrice/>
        <p>
            <i>refresh the page to get new set of stock prices</i>
        </p>
      </header>
    </div>
  );
}

export default App;
