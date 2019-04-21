package com.learn.jpa.LearnJPA.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.jpa.LearnJPA.entity.User;

//User and its primary key
public interface UserRepository extends JpaRepository<User, Long> {
}
