
import ToDo from './ToDo.js';

export default function ToDoList({taskList, toggleComplete, editTask}) {
  return (<div className="list">
    {taskList.map((task) => {
      return <ToDo task={task} toggleComplete={toggleComplete} editTask={editTask} key={task.id}/>
    })}
    </div>
  )
};