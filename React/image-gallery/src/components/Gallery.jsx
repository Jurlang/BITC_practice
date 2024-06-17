import { useEffect } from 'react';
import { useGlobalContext } from '../contexts/context';
import { useFetch } from '../contexts/useFetch';

const url = `https://api.unsplash.com/search/photos?client_id=i6E96BnHgfUvchNrJK98PhRMomrJbG3Npd4EhSaBXCg`;

const Gallery = () => {
	const { searchTerm } = useGlobalContext();
	const { data, error, isPending } = useFetch(`${url}&query=${searchTerm}`);
	console.log(data);

	if (isPending) {
		return (
			<section className='image-container'>
				<h4>Loading...</h4>
			</section>
		);
	}
	if (error) {
		return (
			<section className='image-container'>
				<h4>{error}</h4>
			</section>
		);
	}
	return (
		<section className='gallery'>
			<ul className='images'>
				{data &&
					data.results.map((item) => {
						const url = item.urls.regular;
						return (
							<li className='img' key={item.id}>
								<img src={item.urls.regular} alt={item.alt_description}></img>
							</li>
						);
					})}
			</ul>
		</section>
	);
};
export default Gallery;