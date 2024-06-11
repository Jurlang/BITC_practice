import React from "react";

const SearchBox = (props) => {
    const handleChange = (e) => {
        props.setSearchValue(e.target.value);
    };
    return (
        <div className="col col-sm-4">
            <input 
				className="form-control" 
				placeholder="영화검색" 
				value={props.searchValue} 
				onChange={handleChange} 
			/>
        </div>
    );
};

export default SearchBox;
