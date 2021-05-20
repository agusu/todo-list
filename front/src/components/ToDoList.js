
import ToDo from './ToDo.js';

export default function ToDoList({taskList, handleToggle, editTask}) {
  return (<div className="list">
    {taskList.map((task) => {
      return <ToDo task={task} handleToggle={handleToggle} editTask={editTask} key={task.id}/>
    })}
    </div>
  )
};