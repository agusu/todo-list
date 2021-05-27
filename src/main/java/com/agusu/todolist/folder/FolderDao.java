package com.agusu.todolist.folder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FolderDao extends CrudRepository<Folder, Integer> {
}
