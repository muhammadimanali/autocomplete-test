import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";


<div style={{ marginTop: 50}}>
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
      </div>
