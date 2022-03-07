package com.learn.springboot.entity.teacher;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TeacherService extends PagingAndSortingRepository<Teacher, Long> {

    /**
     * 获取所有学生信息
     * @return
     */
    @Query("from Teacher s where s.isEnabled=1")
    Slice<Teacher> getAllTeachers(Pageable pageable);
}
