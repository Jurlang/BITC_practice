/* eslint-disable react/prop-types */
import '../../css/Table.css';

const Table = ({ headings, children }) => {
	return (
		<table className='common_table'>
			<thead>
				<tr>
					{headings.map((item, index) => (
						<th key={index}>{item}</th>
					))}
				</tr>
			</thead>
			{children}
		</table>
	);
};

export default Table;