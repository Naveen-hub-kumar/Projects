const taskInput = document.getElementById("taskInput");
const addTaskBtn = document.getElementById("addTaskBtn");
const taskList = document.getElementById("taskList");

addTaskBtn.addEventListener("click", addTask);

function addTask() {
    const taskText = taskInput.value.trim();

    if (taskText !== "") {
        const taskItem = document.createElement("li");

        const taskContent = document.createElement("span");
        taskContent.textContent = taskText;
        taskItem.appendChild(taskContent);

        const completeBtn = document.createElement("button");
        completeBtn.textContent = "Complete";
        completeBtn.classList.add("complete");
        completeBtn.addEventListener("click", toggleComplete);
        taskItem.appendChild(completeBtn);

        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.classList.add("delete");
        deleteBtn.addEventListener("click", deleteTask);
        taskItem.appendChild(deleteBtn);

        taskList.appendChild(taskItem);
        taskInput.value = "";
    }
}

function toggleComplete(event) {
    const taskItem = event.target.parentElement;
    taskItem.classList.toggle("completed");
    const completeBtn = taskItem.querySelector(".complete");

    if (taskItem.classList.contains("completed")) {
        completeBtn.textContent = "Undo";
    } else {
        completeBtn.textContent = "Complete";
    }
}

function deleteTask(event) {
    const taskItem = event.target.parentElement;
    taskList.removeChild(taskItem);
}