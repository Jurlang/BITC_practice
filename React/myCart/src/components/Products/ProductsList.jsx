import "../../css/ProductsList.css";
import ProductCard from "./ProductCard";
import useData from "../../Hook/useData";
import ProductCardSkeleton from "./ProductCardSkeleton";
import Pagination from "../Common/Pagination";
import { useSearchParams } from "react-router-dom";
import { useEffect, useState } from "react";

const ProductsList = () => {
  const skeletons = [1, 2, 3, 4, 5, 6, 7, 8];

  const [sortBy, setSortBy] = useState('');
  const [sortedProducts, setSortedProducts] = useState([]);
  
  const [search, setSearch] = useSearchParams();
  const category = search.get("category");
  const page = search.get("page");
  const searchQuery = search.get("search");
  
  const { data, error, isLoading } = useData("products", { params: { search: searchQuery, category, page } }, [searchQuery, category, page]);

  const handlePageChange = (page) => {
    const currentParams = Object.fromEntries([...search]);
    setSearch({ ...currentParams, page: page });
  };

  useEffect(() => {
		if (data && data.products) {
			const products = [...data.products];

			if (sortBy === 'price desc') {
				setSortedProducts(products.sort((a, b) => b.price - a.price));
			} else if (sortBy === 'price asc') {
				setSortedProducts(products.sort((a, b) => a.price - b.price));
			} else if (sortBy === 'rate desc') {
				setSortedProducts(products.sort((a, b) => b.reviews.rate - a.reviews.rate));
			} else if (sortBy === 'rate asc') {
				setSortedProducts(products.sort((a, b) => a.reviews.rate - b.reviews.rate));
			} else {
				setSortedProducts(products);
			}
		}
	}, [sortBy, data]);


  return (
    <section className="products_list_section">
      <header className="align_center products_list_header">
        <h2>상품목록</h2>
        <select name="sort" id="" className="products_sorting" onChange={(e) => setSortBy(e.target.value)}>
          <option value="">정렬방법</option>
          <option value="price desc">가격높은순</option>
          <option value="price asc">가격낮은순</option>
          <option value="rate desc">평점높은순</option>
          <option value="rate asc">평점낮은순</option>
        </select>
      </header>

      <div className="products_list">
        {error && <em className="form_error">{error}</em>}
        {isLoading && skeletons.map((n) => <ProductCardSkeleton key={n} />)}
        {sortedProducts && sortedProducts.map((product) => 
          <ProductCard  key={product._id} product={product} />)}
      </div>

      <Pagination total={data.totalProducts} perPage={8} onClick={handlePageChange} currentPage={page} />
    </section>
  );
};

export default ProductsList;
