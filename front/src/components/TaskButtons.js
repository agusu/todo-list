import { Grid } from '@material-ui/core';
import DeleteButton from './DeleteButton'
import EditButton from './EditButton'

const TaskButtons = ({taskId, editTask, deleteTask }) => {
  return(
    <Grid container justify="space-between">
      <Grid item>
        <EditButton id={taskId} editTask={editTask}/>
      </Grid>
      <Grid item>
        <DeleteButton id={taskId} deleteTask={deleteTask}/>
      </Grid>
    </Grid>
)}

export default TaskButtons;