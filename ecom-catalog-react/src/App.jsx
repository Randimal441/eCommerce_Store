import { useState, useEffect } from 'react'
import ProductList from './ProductList.jsx'
import CategoryFilter from './CategoryFilter.jsx'
import './App.css'

function App() {
  const [products, setProducts] = useState([])
  const [categories, setCategories] = useState([])
  const [selectedCategories, setSelectedCategories] = useState(null)
  const [searchTerm, setSearchTerm] = useState('')
  const [sortOrder, setSortOrder] = useState('asc')

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        console.log('Products fetched:', data);
        setProducts(data);
      })
      .catch(error => {
        console.error('Error fetching products:', error);
        setProducts([]);
      });

    fetch('http://localhost:8080/api/categories')
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        console.log('Categories fetched:', data);
        setCategories(data);
      })
      .catch(error => {
        console.error('Error fetching categories:', error);
        setCategories([]);
      });
  }, []);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  }

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  }

  const handleCategorySelect = (categoryId) => {
    setSelectedCategories(categoryId ? Number(categoryId) : null);
  }

  // Filter and sort products
  const filteredAndSortedProducts = products
    .filter(product => {
      const matchesSearch = product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
                           product.description.toLowerCase().includes(searchTerm.toLowerCase());
      const matchesCategory = !selectedCategories || product.category?.id === selectedCategories;
      return matchesSearch && matchesCategory;
    })
    .sort((a, b) => {
      if (sortOrder === 'asc') {
        return a.price - b.price;
      } else {
        return b.price - a.price;
      }
    });

  return (
    <div className='container'>
      <div className='app-header'>
        <h1>🛍️ Product Catalog</h1>
      </div>

      <div className='filter-section'>
        <div className='row align-items-center'>
          <div className='col-md-3 col-sm-12 mb-3'>
            <label htmlFor="categorySelect" className="form-label fw-bold">Category</label>
            <div className='category-filter'>
              <CategoryFilter 
                categories={categories} 
                onSelect={handleCategorySelect} 
              />
            </div>
          </div>

          <div className='col-md-5 col-sm-12 mb-3'>
            <label htmlFor="searchInput" className="form-label fw-bold">Search</label>
            <div className='search-input'>
              <input
                id="searchInput"
                type='text'
                className='form-control'
                placeholder='Search products by name or description...'
                onChange={handleSearchChange}
              />
            </div>
          </div>

          <div className='col-md-4 col-sm-12 mb-3'>
            <label htmlFor="sortSelect" className="form-label fw-bold">Sort By</label>
            <div className='sort-dropdown'>
              <select id="sortSelect" className='form-control' onChange={handleSortChange}>
                <option value='asc'>Price: Low to High</option>
                <option value='desc'>Price: High to Low</option>
              </select>
            </div>
          </div>
        </div>
      </div>

      <div className='product-grid'>
        {filteredAndSortedProducts.length ? (
          <ProductList products={filteredAndSortedProducts}/>
        ) : (
          <div className='no-products'>
            <h3>🔍 No Products Found</h3>
            <p>Try adjusting your search criteria or category filter</p>
          </div>
        )}
      </div>
    </div>
  )
}

export default App
