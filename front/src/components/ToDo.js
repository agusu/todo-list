import { Checkbox, ListItem, ListItemIcon, ListItemText, ListItemSecondaryAction} from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import TaskButtons from './TaskButtons';

const ToDo = ({task, toggleComplete, editTask, deleteTask}) => {

  return (
  <ListItem key={task.id} dense button onClick={() => {toggleComplete(task.id)}}>
    <ListItemIcon>
      <Checkbox checked={task.complete} onChange={() => {toggleComplete(task.id)}} tabIndex={-1}
                disableRipple/>
    </ListItemIcon>
    <ListItemText primary={task.name} />
    <ListItemSecondaryAction>
      <TaskButtons taskId={task.id} taskName={task.name} editTask={editTask} deleteTask={deleteTask}/>
    </ListItemSecondaryAction>
  </ListItem>);

}
export default ToDo;