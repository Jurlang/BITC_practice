import iphone from '../../assets/images/iphone-14-pro.webp';
import mac from '../../assets/images/mac-system-cut.jfif';

import HeroSection from './HeroSection'
import FeaturedProducts from './FeaturedProducts';

const HomePage = () => {
	return (
		<div>
			<HeroSection title='아이폰 14 프로 그 이상'
				subtitle='Experience the power of the latest iPhone 14 with our most Pro camera ever.'
				link='/products/667ba2a470e0087948d7d8a9'
				image={iphone} />
			
			<FeaturedProducts />
			
			<HeroSection
				title='궁극의 장비를 세팅하세요'
				subtitle='You can add Studio Display and colour-matched Magic accessories to your bag after configure your Mac mini.'
				link='/products/667ba2a470e0087948d7d8b1'
				image={mac}
			/>
		</div>
	)
}

export default HomePage
