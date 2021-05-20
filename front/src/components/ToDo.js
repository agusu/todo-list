import { Checkbox, Grid } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import TaskButtons from './TaskButtons'

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      alignItems: "baseline"
    },
  buttons: {
    '& > *': {
      
    }
  }
  },
}));
const ToDo = ({task, toggleComplete, editTask, deleteTask}) => {
  const classes = useStyles();

  return (
  <Grid container id={task.id} key={task.id} name="task" direction="row" alignItems="baseline" className={classes.root}>
    <Grid item xs={2} sm={1}><Checkbox checked={task.complete} onChange={() => {toggleComplete(task.id)}}/> </Grid>
    <Grid item xs={8} sm={11} >
      <Grid container justify="space-between">
        <Grid item xs={9}>{task.name}</Grid>
        <Grid item xs={2}>
          <TaskButtons taskId={task.id} taskName={task.name} editTask={editTask} deleteTask={deleteTask}/>
        </Grid>
      </Grid>
    </Grid>
  </Grid>);

}
export default ToDo;