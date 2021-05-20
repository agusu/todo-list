import { Checkbox, ListItem, ListItemIcon, ListItemText, ListItemSecondaryAction} from '@material-ui/core';
import TaskButtons from './TaskButtons';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
  taskText: {
    color: "white"
  }
}));

const ToDo = ({task, toggleComplete, editTask, deleteTask}) => {
  const classes = useStyles();

  return (
  <ListItem key={task.id} dense button onClick={() => {toggleComplete(task.id)}} >
    <ListItemIcon>
      <Checkbox checked={task.complete} onChange={() => {toggleComplete(task.id)}} tabIndex={-1}/>
    </ListItemIcon>
    <ListItemText primary={task.name} className={classes.taskText}/>
    <ListItemSecondaryAction>
      <TaskButtons taskId={task.id} taskName={task.name} editTask={editTask} deleteTask={deleteTask}/>
    </ListItemSecondaryAction>
  </ListItem>);

}
export default ToDo;