import { useState, useEffect } from 'react'
import ProductList from './ProductList.jsx'
import './App.css'

function App() {
  const [products, setProducts] = useState([])
  const [categories, setCategories] = useState([])
  const [selectedCategories, setSelectedCategories] = useState(null)
  const [searchTerm, setSearchTerm] = useState('')
  const [sortOrder, setSortOrder] = useState('asc')

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data));

      fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setCategories(data));
  }, []);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  }

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  }

  return (
    <div className='container'>
      <h1 className='my-4'>Product Catalog</h1>

      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-12'>
          <p>Category Filter</p>
        </div>

        <div className='col-md-5 col-sm-12 mb-12'>
          <input
          type='text'
          className='form-control'
          placeholder='Search Products...'
          onChange={handleSearchChange}
          />
          
        </div>

        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value='asc'>Sort by Price: Low to High</option>
            <option value='desc'>Sort by Price: High to Low</option>
          </select>

        </div>
      </div>

      <div>
        {products.length ? (
          //Display products
          <ProductList products={products}/>
        ) : (
          <p>No Products Found</p>
        )}
      </div>

    </div>
    
  )
}

export default App
