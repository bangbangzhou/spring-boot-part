package com.learn.springboot.entity.student;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface StudentService  extends JpaRepository<Student, Long> {
//    /**
//     * 获取所有学生信息
//     * @return
//     */
//    @Query("from Student s where s.isEnabled=1")
//    List<Student> getAllSutdents();
//}
public interface StudentService extends PagingAndSortingRepository<Student, Long> {

    /**
     * 获取所有学生信息
     * @return
     */
    @Query("from Student s where s.isEnabled=1")
    Slice<Student> getAllSutdents(Pageable pageable);
}
