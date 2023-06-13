import Head from 'next/head'
import React, {useState} from 'react'
import { TextField } from '@mui/material'
import Autocomplete from '@mui/material'
import axios from 'axios'

const getBook = async(str) => {
  try {
    let searchableBook = str.replace(/,/g, "");
    let url = "http://localhost:8080/showBook" + searchableBook;

    let {data} = await axios.get(url);
    return data;

  } catch (error) {
    console.error(error);
  }
};

export default function Home() {

  const [searchBook, setSearchOne] = useState([]);

  const onChangeOne = async (e) => {
    if(e.target.value) {
      let data = await getBook(e.target.value)
      setSearchOne(data)
    }
  };

  return (
    <>
      <Head>
        <title>Create Next App</title>
        <meta name="description" content="Generated by create next app" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <div style={{ marginTop: 50}}>
      {/* <Autocomplete
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
        /> */}
      </div>
    </>
  )
}
