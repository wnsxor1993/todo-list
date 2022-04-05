//
//  TodoCell.swift
//  TodoList
//
//  Created by juntaek.oh on 2022/04/05.
//

import UIKit

class TodoCell: UITableViewCell{
    private var title: UILabel!
    private var contents: UILabel!
    private var author: UILabel!
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        configureLabels()
        addContentViews()
        setConstraints()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        
        configureLabels()
        addContentViews()
        setConstraints()
    }
    
    func setLabelText(title: String, contents: String){
        self.title.text = title
        self.contents.text = contents
    }
    
    private func configureLabels(){
        title = UILabel()
        title.textColor = .black
        title.font = UIFont.boldSystemFont(ofSize: 20)
        
        contents = UILabel()
        contents.numberOfLines = 3
        contents.textColor = .black
        contents.font = UIFont.systemFont(ofSize: 17)
        
        author = UILabel()
        author.text = "author by iOS"
        author.textColor = .systemGray
        author.font = UIFont.systemFont(ofSize: 12)
    }
    
    private func setConstraints(){
        title.translatesAutoresizingMaskIntoConstraints = false
        title.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 5).isActive = true
        title.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 5).isActive = true
        title.widthAnchor.constraint(equalTo: self.contentView.widthAnchor).isActive = true
        
        contents.translatesAutoresizingMaskIntoConstraints = false
        contents.topAnchor.constraint(equalTo: self.title.bottomAnchor, constant: 5).isActive = true
        contents.bottomAnchor.constraint(equalTo: self.author.bottomAnchor, constant: -5).isActive = true
        contents.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 5).isActive = true
        contents.widthAnchor.constraint(equalTo: self.contentView.widthAnchor).isActive = true
        
        author.translatesAutoresizingMaskIntoConstraints = false
        author.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: -5).isActive = true
        author.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 5).isActive = true
        author.widthAnchor.constraint(equalTo: self.contentView.widthAnchor).isActive = true
    }
    
    private func addContentViews(){
        self.contentView.addSubview(title)
        self.contentView.addSubview(contents)
        self.contentView.addSubview(author)
    }
}
