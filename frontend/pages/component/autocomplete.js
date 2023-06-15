import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import React, { useState } from "react";
import axios from 'axios';

const getBook = async(str) => {
    try {
      let searchableBook = str.replace(/,/g, "");
      let url = "http://localhost:8080/showBook/" + searchableBook;
  
      let {data} = await axios.get(url);
      return data;
  
    } catch (error) {
      console.error(error);
    }
  };

export default function FreeSolo() {

    const [searchOne, setSearchOne] = useState([]);
    const [value, setValue] = useState("");

    const onChangeOne = async (e) => {
        if(e.target.value) {
            let data = await getBook(e.target.value)
            setSearchOne(data)
        }   
    };

  return (
      <Autocomplete
          freeSolo
          filterOptions={(x) => x}
          onChange={(e) => setValue(e.target.innerText)}
          options={searchOne ? searchOne.map((obj) => obj.title) : []}
          renderInput={(params) => (
            <TextField
              {...params}
              label="Search One"
              onChange={(e) => onChangeOne(e)}
            />
          )}
        />
  );
}