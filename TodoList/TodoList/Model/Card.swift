//
//  Card.swift
//  TodoList
//
//  Created by 최예주 on 2022/04/07.
//

import Foundation


struct Card: Codable{
    private var id: Int
    private var section: State
    private var title: String
    private var content: String
    private var createdDate: Date
    private var author: String
    
    enum State: String, Codable{
        case todo
        case doing
        case done
    }
    
    enum CodingKeys: String, CodingKey {
        case id
        case section
        case title
        case content
        case createdDate = "created_at"
        case author
        
    }
    

    
}
