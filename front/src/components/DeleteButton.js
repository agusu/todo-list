import React from 'react';
import { IconButton } from '@material-ui/core';
import DeleteIcon from '@material-ui/icons/Delete';

const DeleteButton = ({id, deleteTask}) => { 
  return (
    <div>
      <IconButton aria-label="delete" size="small" onClick={() => deleteTask(id)}>
        <DeleteIcon fontSize="small" />
      </IconButton>
    </div>
  )
}

export default DeleteButton;