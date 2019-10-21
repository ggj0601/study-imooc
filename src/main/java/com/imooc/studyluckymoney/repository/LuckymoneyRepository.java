package com.imooc.studyluckymoney.repository;

import com.imooc.studyluckymoney.domain.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
