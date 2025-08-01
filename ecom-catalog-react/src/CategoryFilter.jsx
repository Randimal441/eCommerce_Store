
const CategoryFilter = ({ categories, onSelect }) => {
  return (
    <div>
      <label htmlFor="categorySelect" className="form-label">Filter by Category:</label>
      <select 
        id="categorySelect"
        className="form-select" 
        onChange={(e) => onSelect(e.target.value)}
      >
        <option value="">All Categories</option>
        {categories.map(category => (
          <option key={category.id} value={category.id}>
            {category.name}
          </option>
        ))}
      </select>
    </div>
  );
};

export default CategoryFilter;