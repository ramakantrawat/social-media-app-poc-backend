/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramakant rawat
 * @version $Id: TagRepo.java, v 0.1 2024-02-01 1:02 AM Ramakant rawat Exp $$
 */
@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {
}
