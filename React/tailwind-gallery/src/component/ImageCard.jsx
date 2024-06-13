import React from "react";
import ImageTag from "./ImageTag";

const ImageCard = (props) => {
    
    const tags = props.image.tags.split(',');

    return (
        <div>
            <div className="max-w-sm rounded overflow-hidden shadow-lg">
                <img
                    src={props.image.webformatURL}
                    alt="강아지 사진"
                    className="w-full"
                />
                <div className="px-6 py-4">
                    <div className="font-bold text-purple-500 text-xl mb-2">{props.image.user}</div>
                    <ul>
                        <li>
                            <strong>Views: </strong> {props.image.views}
                        </li>
                        <li>
                            <strong>Downloads: </strong> {props.image.downloads}
                        </li>
                        <li>
                            <strong>Likes: </strong>{props.image.likes}
                        </li>
                    </ul>
                </div>
                <div className="px-6 py-4">
                    {tags.map( (tag, cnt) => (
                        <ImageTag key={cnt} tag={tag}/>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default ImageCard;
