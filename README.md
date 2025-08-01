# 🛍️ eCommerce Product Catalog

A modern, full-stack eCommerce product catalog application built with **Spring Boot** and **React.js**. This application provides a beautiful, responsive interface for browsing and filtering products with real-time search and category filtering capabilities.

![eCommerce Catalog](https://img.shields.io/badge/React-19.1.0-blue?style=for-the-badge&logo=react)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.8-green?style=for-the-badge&logo=spring-boot)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-orange?style=for-the-badge&logo=mysql)

## ✨ Features

### 🎯 Core Features
- **Product Catalog**: Browse products with beautiful card layouts
- **Category Filtering**: Filter products by category with dropdown selection
- **Real-time Search**: Search products by name and description
- **Price Sorting**: Sort products by price (low to high / high to low)
- **Responsive Design**: Mobile-friendly interface that works on all devices

### 🎨 UI/UX Features
- **Modern Design**: Clean, professional interface with modern color scheme
- **Hover Effects**: Interactive product cards with smooth animations
- **Loading States**: Proper loading indicators and error handling
- **Category Badges**: Visual category indicators on product cards
- **Professional Typography**: Optimized readability and visual hierarchy

### 🔧 Technical Features
- **RESTful API**: Clean, well-structured backend API
- **Database Integration**: MySQL database with JPA/Hibernate
- **CORS Support**: Cross-origin resource sharing enabled
- **Error Handling**: Comprehensive error handling and logging
- **Data Seeding**: Automatic sample data population

## 🛠️ Tech Stack

### Frontend
- **React 19.1.0** - Modern React with hooks
- **Vite 7.0.4** - Fast build tool and dev server
- **Bootstrap 5.3.7** - Responsive CSS framework
- **React Bootstrap 2.10.10** - Bootstrap components for React

### Backend
- **Spring Boot 3.4.8** - Java-based web framework
- **Spring Data JPA** - Database abstraction layer
- **Hibernate** - Object-relational mapping
- **MySQL 8.0+** - Relational database
- **Lombok** - Java boilerplate reduction

### Development Tools
- **Maven** - Java build tool
- **npm** - Node.js package manager
- **ESLint** - JavaScript linting
- **Java 17** - Programming language

## 📁 Project Structure

```
eCommerce_Store/
├── ecom-catalog-react/          # React Frontend
│   ├── src/
│   │   ├── App.jsx             # Main application component
│   │   ├── ProductList.jsx     # Product display component
│   │   ├── CategoryFilter.jsx  # Category filtering component
│   │   ├── App.css             # Application styles
│   │   ├── index.css           # Global styles
│   │   └── main.jsx            # Application entry point
│   ├── package.json            # Frontend dependencies
│   └── vite.config.js          # Vite configuration
├── productcatalog/              # Spring Boot Backend
│   ├── src/main/java/com/ecom/productcatalog/
│   │   ├── controller/         # REST API controllers
│   │   ├── service/            # Business logic services
│   │   ├── repository/         # Data access layer
│   │   ├── model/              # Entity models
│   │   └── config/             # Configuration classes
│   ├── src/main/resources/
│   │   └── application.properties  # Database configuration
│   └── pom.xml                 # Backend dependencies
└── README.md                   # Project documentation
```

## 🚀 Quick Start

### Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Node.js 18** or higher
- **MySQL 8.0** or higher
- **Maven 3.6** or higher
- **npm** or **yarn**

### Installation Steps

#### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/eCommerce_Store.git
cd eCommerce_Store
```

#### 2. Database Setup

1. **Start MySQL Server**
   ```bash
   # On Windows
   net start mysql
   
   # On macOS/Linux
   sudo systemctl start mysql
   ```

2. **Create Database**
   ```sql
   CREATE DATABASE productcatalog;
   ```

3. **Update Database Configuration** (if needed)
   Edit `productcatalog/src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

#### 3. Backend Setup

1. **Navigate to backend directory**
   ```bash
   cd productcatalog
   ```

2. **Build and run the Spring Boot application**
   ```bash
   # Using Maven wrapper
   ./mvnw spring-boot:run
   
   # Or using Maven directly
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

#### 4. Frontend Setup

1. **Open a new terminal and navigate to frontend directory**
   ```bash
   cd ecom-catalog-react
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm run dev
   ```

   The frontend will start on `http://localhost:5173`

#### 5. Access the Application

Open your browser and navigate to:
- **Frontend**: http://localhost:5173
- **Backend API**: http://localhost:8080

## 📚 API Endpoints

### Products
- `GET /api/products` - Get all products
- `GET /api/products/category/{categoryId}` - Get products by category

### Categories
- `GET /api/categories` - Get all categories

## 🎯 Usage Guide

### Browsing Products
1. The application loads with all products displayed
2. Products are shown in responsive card layouts
3. Each product displays: image, name, description, price, and category

### Filtering Products
1. **Category Filter**: Use the dropdown to filter by specific categories
2. **Search**: Type in the search box to find products by name or description
3. **Sorting**: Use the sort dropdown to arrange products by price

### Responsive Design
- **Desktop**: 3 products per row
- **Tablet**: 2 products per row
- **Mobile**: 1 product per row

## 🔧 Configuration

### Database Configuration
Edit `productcatalog/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productcatalog
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Frontend Configuration
Edit `ecom-catalog-react/vite.config.js` for build settings:
```javascript
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173
  }
})
```

## 🗄️ Sample Data

The application comes with pre-loaded sample data:

### Categories
- Electronics
- Clothing
- Home and Kitchen

### Products
- Smart Phone ($699.99) - Electronics
- Laptop ($999.99) - Electronics
- Winter Jacket ($299.99) - Clothing

## 🛠️ Development

### Running in Development Mode

#### Backend
```bash
cd productcatalog
./mvnw spring-boot:run
```

#### Frontend
```bash
cd ecom-catalog-react
npm run dev
```

### Building for Production

#### Backend
```bash
cd productcatalog
./mvnw clean package
java -jar target/productcatalog-0.0.1-SNAPSHOT.jar
```

#### Frontend
```bash
cd ecom-catalog-react
npm run build
npm run preview
```

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure MySQL is running
   - Check database credentials in `application.properties`
   - Verify database `productcatalog` exists

2. **Port Already in Use**
   - Backend: Change port in `application.properties`
   - Frontend: Change port in `vite.config.js`

3. **CORS Errors**
   - Ensure backend is running on port 8080
   - Check CORS configuration in controllers

4. **Build Errors**
   - Clear node_modules: `rm -rf node_modules && npm install`
   - Clear Maven cache: `./mvnw clean`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- React team for the amazing frontend library
- Bootstrap team for the responsive CSS framework
- MySQL team for the reliable database

---

⭐ **Star this repository if you found it helpful!**
