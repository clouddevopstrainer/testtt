import React, { useEffect, useState } from 'react';
import ProductList from './components/ProductList';

function App() {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(res => res.json())
      .then(data => setProducts(data));
  }, []);
  return (
    <div>
      <h1>Walmart Products</h1>
      <ProductList products={products} />
    </div>
  );
}

export default App;
