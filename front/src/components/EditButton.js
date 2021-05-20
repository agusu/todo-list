import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import { IconButton } from '@material-ui/core';
import CreateIcon from '@material-ui/icons/Create';
const EditButton = ({id, name, editTask}) => { 
  const [open, setOpen] = React.useState(false);
  const [ userInput, setUserInput ] = React.useState(name);
  
  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (e) => {
    setUserInput(e.currentTarget.value);
  }

  return (
    <div>
      <IconButton aria-label="edit" size="small" onClick={handleClickOpen}>
        <CreateIcon fontSize="small" />
      </IconButton>
      <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Edit task</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Task"
            variant="filled"
            type="text"
            value={userInput}
            onChange={handleChange}
            fullWidth
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          <Button onClick={() => { handleClose(); editTask(id, userInput); }} color="secondary">
            Save
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  )
}

export default EditButton;