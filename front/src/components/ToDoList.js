
import ToDo from './ToDo.js';

export default function ToDoList({taskList, toggleComplete, editTask, deleteTask}) {
  return (<div className="list">
    {taskList.map((task) => {
      return <ToDo task={task} toggleComplete={toggleComplete} editTask={editTask} deleteTask= {deleteTask} key={task.id}/>
    })}
    </div>
  )
};