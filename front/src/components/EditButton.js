import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import { IconButton } from '@material-ui/core';
import CreateIcon from '@material-ui/icons/Create';
const EditButton = ({id, editTask}) => { 
  return (
    <div>
      <IconButton aria-label="edit" size="small" onClick={() => editTask(id)}>
        <CreateIcon fontSize="small" />
      </IconButton>
    </div>
  )
}

export default EditButton;