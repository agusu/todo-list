package com.agusu.todolist.folder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    Folder findFolderByName(String name);
}
